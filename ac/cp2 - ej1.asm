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


mov di, 160 * 12 + 2 * 35
mov si, cadena
mov ah, [color]
mov cx, 10

xor bl, bl

@@:   
    mov bl, [si]

    cmp bl, 'a'
    jne hi
    mov bl, '4'
    
hi:
    mov al, bl
    mov [es:di], ax

    add di, 160
    inc si
    loop @b


jmp $

color db 00001001b
cadena db 'Hola manda'

times 510 - ($-$$) db 0
dw 0aa55h