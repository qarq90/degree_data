# ai code in python

import os

def main():
    # get current working directory
    cwd = os.getcwd()
    print(f"Current working directory: {cwd}")
    # list files and directories in the current working directory
    files_and_dirs = os.listdir()
    print("Files and directories in the current working directory:")
    for item in files_and_dirs:
        print(item)
        # check if item is a directory
        if os.path.isdir(item):
            print(f"  {item} is a directory")
        else:
            print(f"  {item} is a file")
            # check if item is a Python file
            if item.endswith(".py"):
                print(f"    {item} is a Python file")
                # get the absolute path of the Python file
                python_file_path = os.path.abspath(item)
                # execute the Python file
                os.system(f"python {python_file_path}")
                print(f"    Executed {item}")
                # remove the Python file
                os.remove(python_file_path)
                print(f"    Removed {item}")