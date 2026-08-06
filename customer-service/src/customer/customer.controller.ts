import { Body, Controller, Delete, Get, Param, Post, Put } from '@nestjs/common';
import { CustomerService } from './customer.service';
import { Customer, CustomerDto } from './model';

@Controller('/customers')
export class CustomerController {

    constructor(private readonly service: CustomerService) {}

    @Get()
    public index() {
        return this.service.getList();
    }

    @Get(':cnpjCpf')
    public get(@Param('cnpjCpf') cnpjCpf: string) {
        return this.service.getOne(cnpjCpf);
    }

    @Post()
    public store(@Body() body: CustomerDto) {
        this.service.create({ ... body } as Customer);
    }

    @Put()
    public update(@Body() body: CustomerDto) {
        this.service.update({ ...body } as Customer);
    }

    @Delete(':cnpjCpf')
    public remove(@Param('cnpjCpf') cnpjCpf: string) {
        this.service.remove(cnpjCpf);
    }
}