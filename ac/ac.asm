format binary as 'img'
org 7c00h

MOV Ax, 13h
INT 10h
MOV Ax, 0A000h
MOV Es,Ax
XOR AX, AX
MOV DI, 320*3+3
MOV Cx, 78
MOV EAx, 05050505h
MOV AX,DI
MOV SI, Ax
etiqueta:
        MOV [ES:SI], EAx
        MOV [ES:SI+320], EAx
        MOV [ES:SI+320*2], EAx
        MOV [ES:SI+320*3], EAx
        ADD SI, 4
LOOP etiqueta

MOV [ES:SI+1], EAx
MOV [ES:SI+321], EAx
MOV [ES:SI+321*2], EAx
MOV [ES:SI+321*3], EAx
SUB SI, 2
ADD SI, 320*4
MOV Cx, 188
etiqueta1:
        MOV [ES:SI], EAx
        ADD SI, 320
LOOP etiqueta1
ADD DI, 320*4
MOV Cx, 188
etiqueta2:
        MOV [ES:DI], EAx
        ADD DI, 320
LOOP etiqueta2
ADD DI, 4
MOV Cx, 76
etiqueta3:
        MOV [ES:SI], EAx
        MOV [ES:SI-320], EAx
        MOV [ES:SI-320*2], EAx
        MOV [ES:SI-320*3], EAx
        ADD SI, 4
LOOP etiqueta3


times 510 - ($-$$) db 0
dw 0aa55h