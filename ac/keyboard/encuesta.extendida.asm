format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax

mov ax, 40h
mov es, ax 

@@:
    mov al, [es:17h]
    and al, 00000110b  ;shift-izq + ctrl
    cmp al, 00000110b
    jne @b

    ; in al, 60h
    ; cmp al, 39h
    ; jne @b


call print


jmp $


print:
    mov ax, 13h
    int 10h
    mov ax, 0a000h
    mov es, ax

    xor di, di
    mov ax, 0102h
    mov [es:di], ax
    ret

times 510-($-$$) db 0
dw 0xaa55