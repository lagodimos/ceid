#include <stdio.h>
#include <stdlib.h>

#define OPERAND 1
#define STACK_SIZE 2

typedef struct stack {
	int sp;
	int stack[STACK_SIZE];
} Stack;

int getOp(char op[]);
void putInStack(Stack *st, char s[]);
int getFromStack();
void add(Stack *st);
void sub(Stack *st);
void mul(Stack *st);
void divi(Stack *st);
void presentResult(Stack *st);
void push(Stack *st, int n);
int pop(Stack *st);

int main(int argc, char *argv[]) {
	char operand[20];
	int inputType;

	Stack st = {0};

	printf("RPN Calculator\n");

	while((inputType=getOp(operand)) != EOF) {

		switch(inputType) {
			case OPERAND:
				putInStack(&st, operand);
				break;
			case '+':
				add(&st);
				break;
			case '-':
				sub(&st);
				break;
			case '*':
				mul(&st);
				break;
			case '/':
				divi(&st);
				break;
			case '=':
				presentResult(&st);
				break;
			default:
				printf("operation not suported\n");
		}
	}

	return 0;
}

int getOp(char op[]) {
	char ch;

	ch=getchar();
	while(ch==' '|| ch=='\n')
		ch=getchar();
	if(isdigit(ch)){
		op[0]=ch;
		op[1]='\0';
		return OPERAND;
	}
	else
		return ch;
}


void putInStack(Stack *st, char s[]) {
	push(st, atoi(s));
}

int getFromStack() {

}

void add(Stack *st) {
	push(st, pop(st) + pop(st));
}

void sub(Stack *st) {
	int n = pop(st);
	push(st, pop(st) - n);
}

void mul(Stack *st) {
	push(st, pop(st) * pop(st));
}

void divi(Stack *st) {
	int divisor = pop(st);

	if (divisor != 0)
		push(st, pop(st) / divisor);
	else {
		push(st, divisor);
		printf("Division by 0! Operation ignored.");
	}
}

void presentResult(Stack *st) {
	printf("result=%d\n",pop(st));
}

void push(Stack *st, int n) {

	if(st->sp>=STACK_SIZE)
		printf("Stack full\n");
	else
		st->stack[st->sp++]=n;
}

int pop(Stack *st) {
	if(st->sp==0)
		printf("stack empty\n");
	else
		return st->stack[--st->sp];
}
