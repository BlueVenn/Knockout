$logFile = "C:\Knockout build.log"
if(Test-Path -Path $logFile)
{
	Remove-Item -Path $logFile
	New-Item -ItemType file -Path $logFile
}

$workDir = $args[0]
Add-Content -Path $logFile -Value "Working Dir = $workDir"
if (!(Test-Path -Path $workDir))
{
	Add-Content -Path $logFile -Value "Working Dir not found"
	exit
}

$siteDir = [System.IO.Path]::Combine($workDir, "Site")

$scriptsDir = [System.IO.Path]::Combine($siteDir, "Scripts")
Add-Content -Path $logFile -Value "Scripts Dir = $scriptsDir"
if (!(Test-Path -Path $scriptsDir))
{
	Add-Content -Path $logFile -Value "Scripts Dir not found"
	exit
}

$templatesDir = [System.IO.Path]::Combine($siteDir, "Templates")
Add-Content -Path $logFile -Value "Templates Dir = $templatesDir"
if (!(Test-Path -Path $templatesDir))
{
	Add-Content -Path $logFile -Value "Templates Dir not found"
	exit
}

$knockFile = [System.IO.Path]::Combine($siteDir, "knockout.html")
Add-Content -Path $logFile -Value "knockout file = $knockFile"
if (!(Test-Path -Path $knockFile))
{
	Add-Content -Path $logFile -Value "knockout file not found"
	exit
}

$targetDir = "\\JB-2012R2-TEST\C$"
$targetDir = [System.IO.Path]::Combine($targetDir, "Websites")
$targetDir = [System.IO.Path]::Combine($targetDir, "Knockout")
if (!(Test-Path -Path $targetDir))
{
	Add-Content -Path $logFile -Value "Target Dir not found"
	exit
}
else
{
	Add-Content -Path $logFile -Value "Copying files"
	Copy-Item -Path $scriptsDir -Recurse -Destination $targetDir -Force
	Copy-Item -Path $templatesDir -Recurse -Destination $targetDir -Force
	Copy-Item -Path $knockFile -Destination $targetDir -Force
	Add-Content -Path $logFile -Value "Files copied"
}

