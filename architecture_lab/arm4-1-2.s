.arm
.text
.global main

main:
stmdb R13!, {r0 - r5}

@ r1: index
@ r2: last index + 1
@ r3: max value idx
@ r4: max value

mov r1, #0
mov r2, #4

mov r3, #0
mov r4, #0x80000000

loop:
@ Calculate next address to r0
ldr r0, =Values
mov r5, #3
mul r5, r5, r1
add r0, r0, r5

bl subroutine

@ save result and idx if it's the current max
cmp r4, r0
movlt r3, r1
movlt r4, r0

add r1, r1, #1

@ Loop again if iteration < 4
cmp r1, r2
blt loop

@ Save max to memory
ldr r0, =Const
strb r4, [r0, #3]
strb r3, [r0, #4]

ldmia R13!, {r0 - r5}

subroutine:
@ r0 has the address of a

@ r1: temporary result
@ r2: current term
@ r3: base address of constants
@ r4: current constant

@ Store registers that we use
stmdb r13!, {r1 - r4}

@ Load address of Const
ldr r3, =Const

@ Calculate a * z0 in r1
ldrb r2, [r0, #0]
ldrb r4, [r3, #0]
mul r1, r2, r4

@ Calculate b * z1 and add it to r1
ldrb r2, [r0, #1]
ldrb r4, [r3, #1]
mul r2, r2, r4
add r1, r1, r2

@ Calculate c * z2 and subtract it from r1
ldrb r2, [r0, #2]
ldrb r4, [r3, #2]
mul r2, r2, r4
sub r1, r1, r2

@ Store value to r0
mov r0, r1

@ Muliply by 5 and divide by 64
mov r1, #5
mul r0, r0, r1
mov r0, r0, asr #6

@ Restore registers except r0
ldmia r13!, {r1 - r4}

mov pc, lr
@ end of subroutine (return to main)

.data
Values:
.byte 0x02, 0x03, 0x04
.byte 0x10, 0x05, 0x06
.byte 0x0B, 0x02, 0x0D
.byte 0x01, 0x0C, 0x08

Const:
.byte 0x04, 0x07, 0x05
