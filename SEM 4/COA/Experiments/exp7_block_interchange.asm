.model small
.stack 100h
.data
blk1 db 01,02,03,04,05,06,07,08,09,0Ah
blk2 db 0ah dup(?)
count dw 0ah
.code
main proc
mov ax, @data
mov ds, ax
mov es, ax
mov si, offset blk1
mov di, offset blk2
mov cx, count
cld
rep movsb
main endp
end main