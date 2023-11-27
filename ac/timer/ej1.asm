format binary as 'img'
org 7C00h
mov ax, ds
mov es, ax


mov di, 3999
xor dl, dl
xor ax, ax
mov es, ax
mov ax, timer
mov [es:4*8], ax
mov [es:4*8+2], cs
sti

@@:
    cmp dl, 18
    jne @b

pintar:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax
    mov ah, 00101100b
    mov al, '0'
    mov [es:di], ax

    sub di, 2
    cmp di, 0
    jbe @f

    mov dl,0
    jmp @b

@@:

jmp $


timer:
    cli
    inc dl
    mov al, 20h
    out 20h, al
    sti
    iret

times 510-($-$$) db 0
 dw 0xaa55