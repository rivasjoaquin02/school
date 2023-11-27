format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax


@@:
    xor ax, ax
    mov ah, 01h
    int 16h    ;ah (scan)  al (ascii)

    cmp al, 'w'
    je @f

    cmp al, 's'
    je @f


    cmp al, 'a'
    je @f


    cmp al, 'd'
    je @f

    jmp @b

@@:
    mov [key], al
    call print


jmp $

key db 0

print:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax

    mov ah, 01001101b
    mov al, [key]
    mov di, 160 * 12 + 2 * 40
    mov [es:di], al
    ret

times 510-($-$$) db 0
dw 0xaa55