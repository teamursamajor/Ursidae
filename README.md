# Ursidae
Common Ursa Major FRC library (WIP?)

## How to install?
1. Run
```
git submodule init https://github.com/teamursamajor/Ursidae ursidae
```
2. Modify `settings.gradle`
```
...
include ':ursidae'
...
```
3. Modify `build.gradle`
```
dependencies {
    ...
    :compile project(':ursidae')
    ...
}
```