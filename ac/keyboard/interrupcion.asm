format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax


;teclado por interrupcion de hardware
xor ax, ax
mov es, ax
mov ax, keyboard
mov [es:9 * 4], ax       ;int 9
mov [es:9 * 4 + 2], cs   ;int 9


mov cx, 0
mov di, 160 * 12 + 2 * 40
mov si, 0
mov ah, 11101001b


jmp $

cadena db 'hello world'

keyboard:
    cli

    ;bit de estado 60h - saber cual tecla se presiono
    in 60h, al 
    ; cmp al, 128   ;saber si la tecla esta liberada   128 _ _ _ _ _ _ 
    cmp al, 127   ;saber si la tecla esta presionada   0 _ _ _ _ _ _ 
    ja @b

    cmp al, 39h   ;saber si se presiono 'space'
    jne @b

    ;codigo
    inc cx
    cmp cx, 11
    jae @f
    mov al, 'x'
    mov [es:di], a 

@@:
    mov al, 20h
    out 20h, al
    sti 
    iret


times 510 - ($-$$) db 0
dw 0aa55h