format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax

; Inicializa el registro CX a 0
xor cx, cx
mov cx, 0

; Bucle que espera a que se presione una tecla
@@:
    in al, 64h 
    test al, 1   ; Comprueba si se ha presionado una tecla
    jz @b      

    in al, 60h
    cmp al, 39h  ; Comprueba si la tecla presionada fue 'espacio'
    jne @b

    in al, 127
    cmp al, 127
    jb @b

    ; Incrementa CX y comprueba si es igual a 5
    inc cx 
    cmp cx, 5
    jne @b

; Imprime 'o' después de que se haya presionado 'espacio' 5 veces
mov ah, 01001000b
mov al, 'o'
call pintar

; Bucle que espera a que se presione una tecla
@@:
    in al, 64h
    test al, 1
    jz @b

    in al, 60h
    cmp al, 1ch
    jne @b

; Imprime 'e' después de que se haya presionado 'enter'
mov ah, 0110010b
mov al, 'e'
call pintar
    
; Muestra el carácter en la pantalla
xor di, di
mov [es:di], ax 

; Salta a la dirección actual (bucle infinito)
jmp $

pintar:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax
    mov [es:di], ax
    ret


times 510 - ($-$$) db 0
dw 0aa55h
