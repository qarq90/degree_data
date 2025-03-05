.model small
.stack 100h
.data
    v1 db 22h
    v2 db 11h
.code
main proc
    mov ax, @data
    mov dx, ax
    mov ax, 0000h
    mov al, v1
    mov al, 2     
    int 21h      
    mov ah, 4Ch     
    int 21h         
main endp
end main