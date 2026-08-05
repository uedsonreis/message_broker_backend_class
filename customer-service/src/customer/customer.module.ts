import { Module } from '@nestjs/common';

import { CustomerService } from './customer.service';
import { CustomerController } from './customer.controller';
import { CustomerMessageBroker } from './customer.message.broker';

@Module({
    controllers: [CustomerController],
    providers: [CustomerMessageBroker, CustomerService],
})
export class CustomerModule {}