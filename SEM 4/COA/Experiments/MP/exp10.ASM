.model small
.stack 100h
.data
    str1 db "madam$"
    L dw ($ - str1 - 1)
    rstr db 10 dup('$')
    msg1 db "its palindrome$"
    msg2 db "its not palindrome$"
.code
main proc
    mov ax, @data
    mov ds, ax
    mov es, ax
    
    mov cx, L
    lea si, str1
    lea di, rstr
    add di, cx
    dec di
    
back:
    mov al, [si]
    mov [di], al
    inc si
    dec di
    loop back
    
    mov cx, L
    lea si, str1
    lea di, rstr
    repe cmpsb
    
    jne notpal
    
    lea dx, msg1
    jmp disp
    
notpal:
    lea dx, msg2
    
disp:
    mov ah, 9
    int 21h
    
    mov ah, 4ch
    int 21h
main endp
end main