/*
 * #%L
 * Advanced Java LIVE course-2020
 * %%
 * Copyright (C) 2020 MasterDevSkills.com
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package com.masterdevskills.cha1.ext1;

import java.awt.desktop.FilesEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.nio.file.Files;

/**
 * TODO : Write a file processor that would read text from a text file.
 * Discard the empty line
 * Log the count of the lines of the file
 * Write in another file
 */

public class FileProcessor {

    /**
     * Add your code in the following method
     * This method is supposed to read text from given file
     * and return the all the lines as a List of string
     *
     * @param fileName the filename
     *                 <p>
     *                 hints:
     * @see List#removeIf(Predicate)
     */
    public List<String> readFileFrom(String fileName) {

        try {
            var lines = Files.readAllLines(Paths.get(fileName));
            lines.removeIf(String::isEmpty);
            return lines;

        } catch (IOException e) {
           return new ArrayList<>();
        }

    }


    /**
     * TODO: Implement this method that takes a list of string and write in a file
     *
     * @param lines    list of string
     * @param fileName fileName to write
     *                 <p>
     *                 hints
     * @see String#join(CharSequence, CharSequence...)
     */
    public void writeToFile(List<String> lines, String fileName) {

        String content=String.join("\n",lines);

        try {
            Files.writeString(Paths.get(fileName),content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

