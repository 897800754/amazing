/*
 * Copyright (c) 2007, 2020, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sun.org.apache.xerces.internal.parsers;

import com.sun.org.apache.xerces.internal.impl.Constants;
import com.sun.org.apache.xerces.internal.impl.dv.DTDDVFactory;
import com.sun.org.apache.xerces.internal.util.SymbolTable;

/**
 * @version $Id: XMLGrammarParser.java,v 1.6 2010-11-01 04:40:10 joehw Exp $
 */
public abstract class XMLGrammarParser
        extends XMLParser {

    //
    // Data
    //

    /**
     * fDatatypeValidatorFactory
     */
    protected DTDDVFactory fDatatypeValidatorFactory;

    //
    // Constructors
    //

    /**
     * Construct an XMLGrammarParser with the specified symbol table
     *
     * @param symbolTable
     */
    protected XMLGrammarParser(SymbolTable symbolTable) {
        super(new XIncludeAwareParserConfiguration());
        fConfiguration.setProperty(Constants.XERCES_PROPERTY_PREFIX + Constants.SYMBOL_TABLE_PROPERTY, symbolTable);
    }

} // class XMLGrammarParser
