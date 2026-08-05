import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import type { Customer } from './model';

@Injectable()
export class CustomerService {
    
    private customerDB: Customer[] = [];

    public getList() {
        return this.customerDB;
    }

    public getOne(cnpjCpf: string) {
        return this.customerDB.find(c => c.cnpjCpf === cnpjCpf);
    }

    public create(customer: Customer) {
        const saved = this.getOne(customer.cnpjCpf);
        if (saved) throw new HttpException('CNPJ/CPF já cadastrado!', HttpStatus.BAD_REQUEST);

        this.customerDB.push(customer);
    }

    public update(customer: Customer) {
        const saved = this.getOne(customer.cnpjCpf);
        if (!saved) throw new HttpException('CNPJ/CPF não encontrado!', HttpStatus.BAD_REQUEST);

        saved.name = customer.name;
        saved.email = customer.email;
        saved.address = customer.address;
    }

    public remove(cnpjCpf: string) {
        this.customerDB = this.customerDB.filter(c => c.cnpjCpf !== cnpjCpf);
    }
}