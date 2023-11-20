format binary as 'img'
org 7c00h

mov ax, cs
mov ds, ax

mov ax, 03h ;modo texto
int 10h     ;interrump el bios para trab video

mov ax, 0b800h  ;define dir memoria modo text
mov es, ax      ;establece dir memoria

mov di, 160 * 2 + 2 * 3
mov al, 'I'
mov ah, 11000001b  ;parpadeo rojo - letra azul

mov [es:di], ax  ;stosw

jmp $


times 510 - ($-$$) db 0
dw 0AA55h