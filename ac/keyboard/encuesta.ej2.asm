format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax


xor ax, ax
mov es, ax
mov ax, timer
mov [es:8*4], ax
mov [es:8*4+2], cs


@@:
    in al, 64h
    test al, 1
    jz @b

    in al, 60h
    cmp al, 127
    jae @b

    cmp al, 39h
    jne @b

    call print 

    xor cx, cx
@@:
    cmp cx, 18 * 2
    jne @b

    mov ax, 3
    int 10h

jmp $

print:
    mov ax, 13h
    int 10h
    mov ax, 0a000h
    mov es, ax

    mov di, 320 * 100 + 160
    mov eax, 01020304h

    mov [es:di], eax
    ret

timer:
    cli

    inc cx

    mov al, 20h
    out 20h, al
    sti
    iret


times 510-($-$$) db 0
dw 0xaa55