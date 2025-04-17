.model small
.stack 100h
.data
a db 52h
b db 02 dup(?)
.code
main proc
mov ax, @data
mov ds, ax
lea si, a
mov al, [si]
mov bl, al
and bl, 0fh
mov cl, 04h
ror al, cl
and al, 0fh
mov [si+1], al
mov [si+2], bl
int 3
main endp
end main