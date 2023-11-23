format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax


xor si, si
xor di, di   
mov di, 160 * 12 + 80  ;posicion inicial (40,12)


@@:
	;fue presionada una tecla?
    in al, 64h
    test al, 1
    jz @b
    
    ;esta presionada o soltada?
    in al, 60h
    cmp al, 127
    ja @b
    
    ;codigo
    mov bh, [color]
    mov bl, [cadena + si]
    call print

    add di, 2  ;pos en pantalla
    inc si     ;offset - puntero a cadena

    cmp si, 11
    jne @b

jmp $

color db 01001001b
cadena db 'Hello World'

print:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax

    mov [es:di], bx

    ret


times 510-($-$$) db 0
dw 0aa55h