

mov cx, 32
mov si, 0

@@:
    mov al, word1[si]
    mov [word2 + si], al   
    inc si
    loop @@

ret


word1 db 'Hello my name is Geovani Jeorgio', 0
word2 db 32 rep(?)