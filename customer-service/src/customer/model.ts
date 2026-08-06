
import { Type } from 'class-transformer';
import { IsEmail, IsNotEmpty, IsString, ValidateNested } from 'class-validator';

class AddressDto {

    @IsNotEmpty()
    postalCode: string | undefined;

    @IsString()
    @IsNotEmpty()
    description: string | undefined;

    @IsString()
    @IsNotEmpty()
    city: string | undefined;
}

export class CustomerDto {

    @IsNotEmpty()
    cnpjCpf: string | undefined;

    @IsString()
    @IsNotEmpty()
    name: string | undefined;
    
    @IsEmail()
    email: string | undefined;

    @ValidateNested()
    @Type(() => AddressDto)
    address: AddressDto | undefined;
}

export interface Customer {
    cnpjCpf: string;
    name: string;
    email: string;
    address: Address;
}

export interface Address {
    postalCode: string;
    description: string;
    city: string;
}