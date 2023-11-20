format binary as "img"
org 7c00h

mov ax, cs
mov ds, ax

;cleaning 
xor ax, ax
xor si, si
xor di, di
xor cx, cx

;text mode
mov ax, 3
int 10h

mov ax, 0b800h
mov es, ax 

mov di, 160 * 6 + 2 * 3
mov si, cadena
mov ah, [color]
mov cx, 20

xor bx, bx

@@:
    inc bx
    
    mov al, [si]
    mov [es:di], ax

    cmp bx, 2
    jne hi
    xor bx, bx
    add di, 160
    jmp ho

hi:
    add di, 2

ho:
    inc si
    loop @b


jmp $

color db 01111010b
cadena db '00', '01', '02', '03', '04', '05', '06', '07', '08', '09'

times 510 - ($-$$) db 0
dw 0aa55h