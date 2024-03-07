#!/usr/bin/env bash

for dir in $(find "$(pwd)" -type d -name '*_test'); do
    if [ -f "$dir/package.json" ]; then
        echo "Running tests in $dir"
        cd $dir
        npx playwright test
    fi
done
