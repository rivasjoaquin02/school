format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax

;modo texto
mov ah, 3
int 10h
mov ax, 0b800h
mov es, ax

mov cx, 11
xor si, si
xor di, di
mov bh, 01001001b

@@:
    mov ah, 0
    int 16h 

    mov bl, [cadena+si]
    mov [es:di], bx
    inc si

    add di, 2
    loop @b

jmp $

cadena db 'hello world'

times 510-($-$$) db 0
dw 0aa55h