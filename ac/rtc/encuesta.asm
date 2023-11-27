format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax

; se escribe en el 70h el valor que se desea conocer 
; y se lee en el 71h. por ejemplo para las horas:
mov al, 4    ;se pasa el registro hora, peticion 
out dx, 70h   ;se manda a llamar al rtc - se conecta por el 70h
in al, 71h   ;pedimos la propiedad y lo guardamos en al

call pintar


jmp $

pintar:
    mov ax, 3 
    int 10h
    mov ax, 0b800h
    mov es, ax

    xor di, di

    mov ah, 10011100b
    mov [es:di], ax

    ret

times 510-($-$$) db 0
dw 0xaa55