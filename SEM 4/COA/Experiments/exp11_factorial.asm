.model small
.stack 100h
.data
num dw 5
result dw (?)
.code
main proc
mov ax, @data
mov ds, ax
mov ax, 01
mov cx, num
cmp cx, 00
je loop1
mov bx, cx
call fact
loop1: mov result, ax
mov ah, 4ch
int 21h
main endp

fact proc
cmp bx, 01
jz loop2
push bx
dec bx
call fact
pop bx
mul bx
ret
loop2: mov ax, 01
ret
fact endp
end