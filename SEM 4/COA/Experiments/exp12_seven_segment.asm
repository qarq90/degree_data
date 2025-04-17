.model small
.stack 100h
.data
porta equ 0d400h
portc equ 0d402h
cr equ 0d403h
fire db 79h,77h,06h,71h,00,00
help db 00,00,73h,38h,79h,76h
.code
mov ax, @data
mov ds, ax
mov al, 80h
mov dx, cr
out dx, al
mov cx, 02h
again: mov di, 50
disp1: lea si, fire
call display
dec di
jnz disp1
mov di, 50
disp2: lea si, help
call display
dec di
jnz disp2
loop again
mov ah, 4ch
int 21h

display proc
mov ah, 0
back: mov al, ah
mov dx, portc
out dx, al
lodsb
mov dx, porta
out dx, al
call delay
inc ah
cmp ah, 6
jnz back
ret
display endp

delay proc
push bx
push cx
mov bx, 0ffh
loop2:
loop1: mov cx, 0fffh
dec bx
jnz loop2
pop cx
pop bx
ret
delay endp
end