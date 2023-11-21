format binary as 'img'
org 7c00h

mov ax, cx
mov ds, ax


;robar el vector de interrupcion
xor ax, ax
mov es, ax
mov ax, timer
mov [es:8*4], ax
mov [es:8*4+2], ax


;inicializa el contador en 0
xor dx, dx


;cuando cuente a 1 seg sigue
@@:
    cmp dx, 18
    jne @b


;calcula los segundos pasados
mov ax, dx
mov bl, 18
div bl
mov [time], al



;modo texto
mov ax, 3
int 10h
mov ax, 0b800h
mov es, ax

mov di, 0
mov ah, 10011100b
mov al, [time]

mov [es:di], ax


jmp $

time db 0

timer:
    cli
    inc dx
    mov al, 20h
    out 20h, al
    sti
    iret


times 510 - ($-$$) db 0
dw 0aa55h