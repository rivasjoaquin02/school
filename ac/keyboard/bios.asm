format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax

call cls

@@:
    xor ah, ah
    int 16h      ;AH = scancode  AL = ascii char

    cmp ah, 39h
    jne @b

    mov [tecla], al

    call print
    jmp @b


jmp $

tecla db 0

print:
    mov ax, 3
    int 10h 
    mov ax, 0b800h
    mov es, ax

    xor di, di

    mov ah, 10101100b
    mov al, 'x'
    mov [es:di], ax

    ret

cls:
    mov ax, 3
    int 10h
    ret

times 510 - ($-$$) db 0
dw 0xaa55
