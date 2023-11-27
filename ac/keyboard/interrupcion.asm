format binary as 'img'
org 7c00h
mov ax, cs
mov ds, ax

;limpiar la pantalla
call cls

;teclado - interrupcion de hardware - int 9
xor ax, ax
mov es, ax
mov ax, keyboard
mov [es:9 * 4], ax    
mov [es:9 * 4 + 2], cs

sti

mov di, 320 * 100 + 210


jmp $

color db 01h

keyboard:
    ;inicia la atencion a la interrupcion
    cli

    in al, 60h   ;cual tecla se presiono?
    cmp al, 127  ;la tecla esta liberada?
    ja @f
 
    in al, 60h   ;fue la tecla 'space'?
    cmp al, 39h 
    jne @f

    ;codigo
    mov bl, [color]
    call print

@@:
    ;cerrar conexion
    mov al, 20h  ;le manda la instruccion EOI al esclavo
    out 20h, al  ;cierra con el maestro
    sti          ;terminamos de atender la instruccion 
    iret         ;para reiniciar la atencion a las instrucciones

print:
    mov ax, 13h
    int 10h
    mov ax, 0A000h
    mov es, ax

    mov [es:di], bl
    inc di

    ret

cls:
    ;limpiar pantalla
    mov ax, 3
    int 10h
    ret

times 510 - ($-$$) db 0
dw 0aa55h