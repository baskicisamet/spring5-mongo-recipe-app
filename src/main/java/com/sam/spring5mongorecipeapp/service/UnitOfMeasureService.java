package com.sam.spring5mongorecipeapp.service;

import java.util.Set;

import com.sam.spring5mongorecipeapp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();

}
