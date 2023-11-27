format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax


xor ax, ax
mov es, ax
mov ax, show_time
mov [es: 70h * 4], ax
mov [es: 70h * 4 + 2], cs


; clear screen
call cls


jmp $


show_time:
    cli

    ;codigo

    mov al, 20h
    out 20h, al
    sti
    iret

cls:
    mov al, 3
    int 10h
    ret


times 510-($-$$) db 0
dw 0xaa55