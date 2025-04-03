#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *tree; // Tree root
void create_tree();
void insertElement();
void preorderTraversal(struct node *tree);
void inorderTraversal(struct node *tree);
void postorderTraversal(struct node *tree);
void deleteElement();

int main()
{
    int c;
    create_tree();
    do
    {
        printf("\n ******MAIN MENU******* \n");
        printf("\n 1. Insert Element");
        printf("\n 2. Preorder Traversal");
        printf("\n 3. Inorder Traversal");
        printf("\n 4. Postorder Traversal");
        printf("\n 5. Delete an element");
        printf("\n 6. Exit");
        printf("\n\n Enter your option : ");
        scanf("%d", &c);
        switch (c)
        {
        case 1:
            insertElement();
            break;
        case 2:
            printf("\nPreorder Traversal: ");
            preorderTraversal(tree);
            break;
        case 3:
            printf("\nInorder Traversal: ");
            inorderTraversal(tree);
            break;
        case 4:
            printf("\nPostorder Traversal: ");
            postorderTraversal(tree);
            break;
        case 5:
            deleteElement();
            break;
        }
    } while (c != 6);
    return 0;
}

void create_tree()
{
    tree = NULL;
}

void insertElement()
{
    struct node *ptr, *nodeptr, *parentptr;
    int val;
    ptr = (struct node *)malloc(sizeof(struct node));
    printf("\n Enter the value of the new node: ");
    scanf("%d", &val);
    ptr->data = val;
    ptr->left = NULL;
    ptr->right = NULL;

    if (tree == NULL)
    {
        tree = ptr; // Root node
    }
    else
    {
        parentptr = NULL;
        nodeptr = tree;
        while (nodeptr != NULL)
        {
            parentptr = nodeptr;
            if (val < nodeptr->data)
                nodeptr = nodeptr->left;
            else
                nodeptr = nodeptr->right;
        }
        if (val < parentptr->data)
            parentptr->left = ptr;
        else
            parentptr->right = ptr;
    }
}

void preorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        printf("%d\t", tree->data);
        preorderTraversal(tree->left);
        preorderTraversal(tree->right);
    }
}

void inorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        inorderTraversal(tree->left);
        printf("%d\t", tree->data);
        inorderTraversal(tree->right);
    }
}

void postorderTraversal(struct node *tree)
{
    if (tree != NULL)
    {
        postorderTraversal(tree->left);
        postorderTraversal(tree->right);
        printf("%d\t", tree->data);
    }
}

void deleteElement()
{
    struct node *cur, *parent, *suc, *psuc;
    int val;
    if (tree == NULL)
    {
        printf("\n The tree is empty.");
        return;
    }

    printf("\n Enter the element to be deleted: ");
    scanf("%d", &val);

    cur = tree;
    parent = NULL;

    // Search for the element
    while (cur != NULL && cur->data != val)
    {
        parent = cur;
        if (val < cur->data)
            cur = cur->left;
        else
            cur = cur->right;
    }

    if (cur == NULL)
    {
        printf("\n The value to be deleted is not present in the tree.");
        return;
    }

    // Case 1: Node has no children
    if (cur->left == NULL && cur->right == NULL)
    {
        if (parent == NULL) // Node to be deleted is the root node
            tree = NULL;
        else if (parent->left == cur)
            parent->left = NULL;
        else
            parent->right = NULL;
    }
    // Case 2: Node has one child
    else if (cur->left == NULL || cur->right == NULL)
    {
        struct node *child = (cur->left != NULL) ? cur->left : cur->right;
        if (parent == NULL)
            tree = child;
        else if (parent->left == cur)
            parent->left = child;
        else
            parent->right = child;
    }
    // Case 3: Node has two children
    else
    {
        psuc = cur;
        suc = cur->right;

        while (suc->left != NULL)
        {
            psuc = suc;
            suc = suc->left;
        }

        cur->data = suc->data; // Replace with inorder successor

        if (psuc != cur)
            psuc->left = suc->right;
        else
            psuc->right = suc->right;

        cur = suc;
    }

    free(cur);
    printf("\n Element deleted successfully.");
}
