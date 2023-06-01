export interface AuthRequest 
{
    username: string;
    password: string;
}

export interface AuthRegisterRequest extends AuthRequest { }