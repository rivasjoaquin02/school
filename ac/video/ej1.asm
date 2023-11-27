format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax


mov ax, 13h
int 10h
mov ax, 0a000h
mov es, ax


mov di, 320 * 200 + 15
mov cx, 4

@@:
    mov ax, [color]
    mov [es:di], ax


    mov ax, [color1]
    mov [es:di-(320 + 318)], ax
    sub di, 320
    loop @b


jmp $

color dw 0f0fh
color1 dw 0404h

times 510 - ($-$$) db 0
dw 0aa55h 