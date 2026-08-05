import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import type { Customer } from './model';
import { CustomerMessageBroker } from './customer.message.broker';

@Injectable()
export class CustomerService {
    
    private customerDB: Customer[] = [];

    constructor(private readonly messageBroker: CustomerMessageBroker) {}

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
        this.messageBroker.update(customer);
    }

    public update(customer: Customer) {
        const saved = this.getOne(customer.cnpjCpf);
        if (!saved) throw new HttpException('CNPJ/CPF não encontrado!', HttpStatus.BAD_REQUEST);

        saved.name = customer.name;
        saved.email = customer.email;
        saved.address = customer.address;

        this.messageBroker.update(customer);
    }

    public remove(cnpjCpf: string) {
        const customer = this.customerDB.find(c => c.cnpjCpf === cnpjCpf);
        this.customerDB = this.customerDB.filter(c => c.cnpjCpf !== cnpjCpf);

        if (customer) this.messageBroker.remove(customer);
    }
}