@1
.arm
.text
.global main

main:
STMDB R13!, {R0-R12, R14}

MOV R0, #94
MOV R1, R0, LSR #1

ADDS R2, R0, R0 @11 Σημειώστε το περιεχόμενο του καταχωρητή κατάστασης
ADDS R2, R1, R1 @12 Σημειώστε το περιεχόμενο του καταχωρητή κατάστασης
ADDS R2, R0, R1 @13 Σημειώστε το περιεχόμενο του καταχωρητή κατάστασης

MOV R0, #0x80000000
ADD R1, R0, #0x80
MOV R2, #1

SUBS R3, R0, R2 @19 Σημειώστε το περιεχόμενο του καταχωρητή κατάστασης
SUBS R3, R0, R1 @20 Σημειώστε το περιεχόμενο του καταχωρητή κατάστασης
RSBS R3, R0, R1 @21 Σημειώστε το περιεχόμενο του καταχωρητή κατάστασης

LDMIA R13!, {R0-R12, PC}

@	N	Z	C	V
@11	0	0	0	0
@12	0	0	0	0
@13	0	0	0	0
@19	0	0	1	1
@20	1	0	0	0
@21	0	0	1	0

@ Comments
@ Στις 11, 12, 13 τα αποτελέσματα 94 + 94 = 188, 47 + 47 = 94 και 94 + 47 = 141 είναι όλα > 0 και < 2^31 – 1 άρα N=C=V=V=0.

@ 19: R3 = -2^31 - 1 = 0 (wrap-around) άρα N=Z=0, C=1 (100...+ 111..0 + 1), V=Cxor(C-1)=1xor0=1
@ 20: R3 =  -2^31 - (-2^31 + 128) = -128 < 0 άρα N=1, Z=0, C=0 (100.. + 01..101111111 + 1), V=Cxor(C-1)=0xor0=0
@ 21: R3 = (-2^31 + 2^7) - (-2^31)=2^7 άρα N=Z=0, C=1 (10..010..0 + 01… + 1), V=Cxor(C-1)=1xor1=0

@2
.arm
.text
.global main

main:
STMDB R13!, {R0-R12, R14}

mov r0, #0
ldr r1, =Stor
mov r2, #6

loop:
strb r0, [r1, r0]

add r0, r0, #1

cmp r0, r2
blt loop

LDMIA R13!, {R0-R12, PC}

.data
Stor: .byte 0, 0, 0, 0, 0, 0

@3
.arm
.text
.global main

main:
STMDB R13!, {R0-R12, R14}

mov r0, #0
ldr r1, =Stor
mov r2, #6

mov r3, #0
mov r4, #1

loop:
strb r3, [r1, r0]

add r5, r3, r4
mov r3, r4
mov r4, r5

add r0, #1

cmp r0, r2
blt loop

LDMIA R13!, {R0-R12, PC}

.data
Stor: .byte 0, 0, 0, 0, 0, 0
