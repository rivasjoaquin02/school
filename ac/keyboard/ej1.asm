;ENCUESTA
;imprime lo que hay en cadena caracter por caracter
;siempre que se toque una tecla cualquiera
format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax

;modo texto
mov ah, 3
int 10h
mov ax, 0b800h
mov es, ax

mov cx, 11
xor si, si
xor di, di
mov ah, 01001001b

@@:
	;ver si alguna tecla fue presionada
    in al, 64h
    test al, 1
    jz @b
    
    ;saber cual tecla se esta usando
    in al, 60h
    cmp al, 127
    ja @b
    
    ;pintar el caracter en pantalla apartir de (0,0)
    mov al, [cadena+si]
    mov [es:di], ax

    inc si
    add di, 2
    loop @b

jmp $

cadena db 'Hello World'

times 510-($-$$) db 0
dw 0aa55h