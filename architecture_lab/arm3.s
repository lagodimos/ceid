@ r1: A[i]
@ r2: B[i]
@ r3: C[i]

@ r4: a(A[i])
@ r5: a(B[i])
@ r6: a(C[i])

@ r7: a(C[16])

@ ---------- bytes ----------
.arm
.text
.global main

main:
@ Load initial addresses
ldr r4, =A1
ldr r5, =B1
ldr r6, =C1

add r7, r6, #0x10

loop:

@ Load data
ldrb r1, [r4]
ldrb r2, [r5]

@ Add and store to memory
add r3, r1, r2
strb r3, [r6]

@ Update addresses
add r4, r4, #1
add r5, r5, #1
add r6, r6, #1

cmp r6, r7
blt loop

.data
A1: .byte 32, 127, 254, 57, 22, 111, 48, 11, 87, 45, 114, 45, 66, 23, 134, 168
B1: .byte 19, 1, 18, 89, 90, 112, 89, 32, 23, 98, 67, 83, 146, 140, 200, 67
C1: .byte 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0

@ ---------- halfwords ----------

.arm
.text
.global main

main:
@ Load initial addresses
ldr r4, =A1
ldr r5, =B1
ldr r6, =C1

add r7, r6, #0x10

loop:

@ Load data
ldrh r1, [r4]
ldrh r2, [r5]

@ Add and store to memory
add r3, r1, r2
strh r3, [r6]

@ Update addresses
add r4, r4, #2
add r5, r5, #2
add r6, r6, #2

cmp r6, r7
blt loop

.data
A1: .byte 32, 127, 254, 57, 22, 111, 48, 11, 87, 45, 114, 45, 66, 23, 134, 168
B1: .byte 19, 1, 18, 89, 90, 112, 89, 32, 23, 98, 67, 83, 146, 140, 200, 67
C1: .byte 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0

@ ---------- words ----------

.arm
.text
.global main

main:
@ Load initial addresses
ldr r4, =A1
ldr r5, =B1
ldr r6, =C1

add r7, r6, #0x10

loop:

@ Load data
ldr r1, [r4]
ldr r2, [r5]

@ Add and store to memory
add r3, r1, r2
str r3, [r6]

@ Update addresses
add r4, r4, #4
add r5, r5, #4
add r6, r6, #4

cmp r6, r7
blt loop

.data
A1: .byte 32, 127, 254, 57, 22, 111, 48, 11, 87, 45, 114, 45, 66, 23, 134, 168
B1: .byte 19, 1, 18, 89, 90, 112, 89, 32, 23, 98, 67, 83, 146, 140, 200, 67
C1: .byte 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0

@ ---------- longwords ----------

@ r8: carry

.arm
.text
.global main

main:
@ Load initial addresses
ldr r4, =A1
ldr r5, =B1
ldr r6, =C1

add r7, r6, #0x10

@ Initialize carry to 0
mov r8, #0

loop:

@ Load data
ldr r1, [r4]
ldr r2, [r5]

@ Add and store to memory
adds r3, r1, r2
add r3, r3, r8
str r3, [r6]

@ Store carry to r8
mov r8, #0
movcs r8, #1

@ Update addresses
add r4, r4, #4
add r5, r5, #4
add r6, r6, #4

cmp r6, r7
blt loop

.data
A1: .byte 32, 127, 254, 57, 22, 111, 48, 11, 87, 45, 114, 45, 66, 23, 134, 168
B1: .byte 19, 1, 18, 89, 90, 112, 89, 32, 23, 98, 67, 83, 146, 140, 200, 67
C1: .byte 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
