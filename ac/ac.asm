format binary as 'img'
org 7c00h

mov ax, 13h
int 10h
mov ax, 0a000h
mov es,ax
xor ax, ax
mov di, 320*3+3
mov cx, 78
mov eax, 05050505h
mov ax,di
mov si, ax
etiqueta:
        mov [es:si], eax
        mov [es:si+320], eax
        mov [es:si+320*2], eax
        mov [es:si+320*3], eax
        add si, 4
loop etiqueta

mov [es:si+1], eax
mov [es:si+321], eax
mov [es:si+321*2], eax
mov [es:si+321*3], eax
sub si, 2
add si, 320*4
mov cx, 188
etiqueta1:
        mov [es:si], eax
        add si, 320
loop etiqueta1
add di, 320*4
mov cx, 188
etiqueta2:
        mov [es:di], eax
        add di, 320
loop etiqueta2
add di, 4
mov cx, 76
etiqueta3:
        mov [es:si], eax
        mov [es:si-320], eax
        mov [es:si-320*2], eax
        mov [es:si-320*3], eax
        add si, 4
loop etiqueta3


times 510 - ($-$$) db 0
dw 0aa55h