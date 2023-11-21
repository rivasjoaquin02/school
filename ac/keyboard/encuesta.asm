format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax

xor cx, cx
mov cx, 0

@@:
    in al, 64h
    test al, 1
    jz @b

    in al, 60h
    cmp al, 39h   ;space
    jne @b

    inc cx 
    cmp cx, 5
    jne @b


;imprime 'o' despues
mov ax, 3
int 10h
mov ax, 0b800h
mov es, ax

mov ah, 01001000b
mov al, 'o'

xor di, di
mov [es:di], ax 


jmp $

times 510 - ($-$$) db 0
dw 0aa55h