.arm
.text
.global main

main:
stmdb R13!, {r0 - r2}

@ r1: current address

ldr r1, =Values
add r2, r1, #16

loop:
@ Store x to r0
ldr r0, [r1]

bl subroutine

add r1, r1, #4

@ Loop again if iteration < 4
cmp r1, r2
blt loop

ldmia R13!, {r0 - r2}

subroutine:
@ Store registers that we use
stmdb r13!, {r1 - r4}

@ r0: x
@ r1: a_i
@ r2: a_i address
@ r3: a's base address
@ r4: temporary result

@ Load address of Const
ldr r3, =Const
mov r4, #0
add r2, r3, #7

loop2:
@ Update offset and load a_i
ldrb r1, [r2, #-1]!

@ Calculate b_(i-1) using b_i
mul r4, r4, r0
add r4, r4, r1

cmp r3, r2
blt loop2

@ Store value to r0
mov r0, r4

@ Restore registers except r0
ldmia r13!, {r1 - r4}

mov pc, lr
@ end of subroutine (return to main)

.data
Values:
.word 0x10
.word 0x50A
.word 0xCDCA
.word 0x80AB

Const:
.byte 0x04, 0x07, 0x05
.byte 0x20, 0x1A, 0x12, 0x06
