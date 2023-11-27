format binary as 'img'
org 7c00h
mov ax, cs
mov es, ax

xor ax, ax
mov es, ax
mov ax, timer
mov [es:8*4], ax
mov [es:8*4+2], cs

sti

xor dx, dx

@@:
    cmp dx, 18 * 3
    jb @b

call print

xor dx, dx
@@:
    cmp dx, 18 
    jb @b

call cls

@@:
    in al, 64h
    test al, 1
    jz @b

    in al, 60h
    cmp al, 127
    jae @b
    
    cmp al, 1ch  ; 'enter'
    je enter_p

    cmp al, 39h  ; 'space'
    je space_p

    mov bl, [space_pressed]
    test [enter_pressed], bl
    jz @b

    call print
    jmp prin

enter_p:
    mov [enter_pressed], 1
    jmp @b

space_p:
    mov [space_pressed], 1
    jmp @b

prin:
    call print

jmp $

enter_pressed db 0
space_pressed db 0

timer:
    cli

    ;code
    inc dx

    mov al, 20h
    out 20h, al
    sti
    iret

print:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax

    mov ah, 11001010b
    mov al, 'x'

    mov [es:0], ax 

    ret

cls:
    mov ax, 3
    int 10h
    mov ax, 0b800h
    mov es, ax
    ret

times 510-($-$$) db 0
dw 0xaa55