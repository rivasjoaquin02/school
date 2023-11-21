format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax


;teclado
xor ax, ax
mov es, ax
mov ax, keyboard
mov [es:9 * 4], ax
mov [es:9 * 4 + 2], cs


mov cx, 0
mov di, 160 * 12 + 2 * 40
mov si, 0
mov ah, 11101001b


jmp $

cadena db 'hello world'

keyboard:
    cli

    inc cx
    cmp cx, 11
    jae @f

    mov al, 'x'
    mov [es:di], ax

@@:
    mov al, 20h
    out 20h, al
    sti 
    iret


times 510 - ($-$$) db 0
dw 0aa55h