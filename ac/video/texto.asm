
format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax


mov ax, 3
int 10h
mov ax, 0b800h
mov es, ax

xor di, di

mov ah, [color] 
mov al, 'x'
mov [es:di], ax


mov ah, [color2]
mov al, 'x'
add di, 160
mov [es:di], ax


jmp $

color db 00001001b
color2 db 00000001b

times 510-($-$$) db 0
dw 0xaa55