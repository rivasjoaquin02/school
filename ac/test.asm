format binary as 'img'
org 7c00h


mov cx, 11
mov si, cadena
mov di, cadena2
@@:
     mov al, [si]
     mov [di], al
     inc si
     inc di
     dec cx

     cmp cx, 0
     je @@


jmp $

cadena db 'Hello world', 0
cadena2 db '           ', 0

times 510 - ($-$$) db 0
dw 0AA55h