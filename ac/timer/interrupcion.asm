format binary as 'img'
org 7c00h
mov ax, cx
mov ds, ax

xor dx, dx


; roba la atencion del vector de interrupcion IRQ-0
xor ax, ax          
mov es, ax   
mov ax, timer       
mov [es:8*4], ax     ; maestro 
mov [es:8*4+2], cs   ; esclavo


sti    ; habilita las interrupciones               


; solo avanza cuando paso 3s
@@:
    cmp dx, 18 * 3
    jne @b

; codigo
mov ax, dx
mov bl, 18
div bl
mov [time], al
call pintar

jmp $

color db 10011100b
time db 0

timer:
    cli          ;inicia la atencion a la int

    ;codigo
    inc dx

    ;cortamos la coneccion maestro-esclavo
    mov al, 20h  ;EOI del 8259
    out 20h, al   ;cierra la conexion con el maestro
    sti          ;terminamos la atencion a la int      
    iret         ;reinicia la atencion a la int

pintar:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax

    ; display the time
    xor di, di
    mov ah, [color]
    mov al, [time]
    
    mov [es:di], ax 
    ret

times 510 - ($-$$) db 0
dw 0aa55h
