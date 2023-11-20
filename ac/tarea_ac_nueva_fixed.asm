format binary as 'img'
org 7c00h

mov ax, cs
mov ds, ax

;cleaning
xor ax, ax
xor si, si
xor di, di
xor cx, cx

;video mode
mov ax, 13h
int 10h
mov ax, 0A000h
mov es, ax

;color
mov eax, [color]

;empieza en (3; 3)
mov di, 320 * 3 + 3
mov cx, 200 - 7

vertical:
        mov [es:di], eax
        mov [es:di + (320 - 10)], eax

        add di, 320    ;321 lo hace en diagonal

        loop vertical

;starts at (3; 3)
mov di, 320 * 3 + 3
mov cx, 78 ; (320 - filas) /pixeles
;queda 2px menos si usas un pincel de 4px,
;pero si usas un pincel de 2px queda exacto
;en este caso no se nota y es mas facil el de 4px

horizontal:
        mov [es:di], eax
        mov [es:di + (320 * 1)], eax
        mov [es:di + (320 * 2)], eax
        mov [es:di + (320 * 3)], eax

        mov [es:di + (320 * (200 - 11))], eax
        mov [es:di + (320 * (200 - 10))], eax
        mov [es:di + (320 * (200 - 9))], eax
        mov [es:di + (320 * (200 - 8))], eax

        add di, 4
        loop horizontal


mov bx, 7   ;bx moves for the columns
mov di, 320 * 7 + 7
mov cx, 153

mov [es:di], eax;
;this is the best diagonal i can think of
diagonal:
        ;mov al, 0.61
        mul bx
        mov di, ax

        mov [es:di], eax
        mov [es:di + (320 * 1)], eax
        mov [es:di + (320 * 2)], eax
        mov [es:di + (320 * 3)], eax

        inc bx
        ;add di, 322
        loop diagonal

jmp $

color dd 04040404h
colortest dd 04030201h
factor db 0.61

times 510 - ($-$$) db 0
dw 0aa55h