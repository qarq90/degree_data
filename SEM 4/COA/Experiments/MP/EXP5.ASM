.model small
.stack 100h
.data
a dw 8111h
b dw 6222h
.code
main proc
mov ax, @data
mov ds, ax
mov ax, a
mov bx, b
adc ax, bx
mov ah, 4ch
int 21h
main endp
end main
